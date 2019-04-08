package com.jacr.pruebatecnica.model.repository.prospect

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jacr.pruebatecnica.model.data.entities.Entity
import com.jacr.pruebatecnica.model.data.entities.ProspectEntity
import com.jacr.pruebatecnica.model.utilities.ApiHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created: 4/8/19.
 * Author: jesus.castro
 */
@SuppressLint("CheckResult")
class ProspectApiRepository @Inject constructor() : ProspectRepository {

    companion object {
        var TAG: Class<Any> = ProspectApiRepository.javaClass
    }

    private var api: ProspectApiEndpoint = ApiHelper.getClient(ProspectApiEndpoint::class.java)

    override fun getProspects(token: String): LiveData<List<Entity<ProspectEntity>>> {
        val rs = MutableLiveData<List<Entity<ProspectEntity>>>()
        api.getProspects(token)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { rs.value = buildEntities(error = it) }
            .subscribe { rs.value = buildEntities(entities = it) }
        return rs
    }

    private fun buildEntities(
        entities: List<ProspectEntity> = ArrayList(), error: Throwable? = null
    ): List<Entity<ProspectEntity>> {
        val l = ArrayList<Entity<ProspectEntity>>()
        when {
            error != null -> l.add(Entity.fromException(TAG, error))
            else -> entities.forEach { l.add(Entity.fromData(it)) }
        }
        return l
    }

}