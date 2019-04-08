package com.jacr.pruebatecnica.model.domain.session

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations.switchMap
import com.jacr.pruebatecnica.model.base.IPrefStorage
import com.jacr.pruebatecnica.model.data.dtos.Dto
import com.jacr.pruebatecnica.model.data.dtos.request.UserRequestDto
import com.jacr.pruebatecnica.model.data.dtos.response.UserDto
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.UserEntity
import com.jacr.pruebatecnica.model.data.mapper.ModelMapper
import com.jacr.pruebatecnica.model.repository.session.ISessionRepository
import javax.inject.Inject

/**
 * Created: 3/31/19.
 * Author: jesus.castro
 */
@SuppressLint("CheckResult")
class SessionDomain @Inject constructor(
    private val modelMapper: ModelMapper<Entity<UserEntity>, Dto<UserDto>>,
    private val userStorage: IPrefStorage<UserDto>,
    private val apiRepository: ISessionRepository
) : ISessionDomain, Observer<Entity<UserEntity>> {

    private var repositoryLiveData: LiveData<Entity<UserEntity>> = MutableLiveData()
    private lateinit var userInput: UserRequestDto

    override fun onChanged(entity: Entity<UserEntity>?) {
        if (entity?.isSuccess()!!) {
            val dto = modelMapper.fromEntity(entity)
            dto.data?.user = userInput
            userStorage.save(dto.data)
        }
        repositoryLiveData.removeObserver(this)
    }

    override fun signIn(user: UserRequestDto): LiveData<Dto<UserDto>> {
        userInput = user
        repositoryLiveData = apiRepository.signIn(user)
        repositoryLiveData.observeForever(this)
        return switchMap(repositoryLiveData) {
            MutableLiveData<Dto<UserDto>>(modelMapper.fromEntity(it))
        }
    }

    override fun getLastAuthInfo(): LiveData<Dto<UserDto>> =
        MutableLiveData<Dto<UserDto>>(Dto.fromData(userStorage.get()))

}