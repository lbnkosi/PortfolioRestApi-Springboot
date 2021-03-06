package za.co.lbnkosi.aboutmeapi.response

import org.bson.types.ObjectId
import za.co.lbnkosi.aboutmeapi.enums.WorkType
import za.co.lbnkosi.aboutmeapi.models.Work
import za.co.lbnkosi.aboutmeapi.requests.AddressRequest
import za.co.lbnkosi.aboutmeapi.requests.ContactRequest
import za.co.lbnkosi.aboutmeapi.requests.WorkRequest
import za.co.lbnkosi.aboutmeapi.response.AddressResponse.Companion.toRequest
import za.co.lbnkosi.aboutmeapi.response.ContactResponse.Companion.toRequest
import java.util.*
import kotlin.collections.ArrayList

class WorkResponse(
    var id: String?,
    var uid: String,
    var alias: String,
    var companyName: String,
    var position: String,
    var startDate: Date,
    var endDate: Date,
    var currentPosition: Boolean,
    var logo: String,
    var description: String,
    var workType: String
) {
    companion object {
        fun ArrayList<Work>.copyWorkToResponse(): ArrayList<WorkResponse> {
            val workList: ArrayList<WorkResponse> = arrayListOf()
            this.forEach {
                workList.add(
                    WorkResponse(
                        id = it.id?.toHexString(),
                        uid = it.uid,
                        alias = it.alias,
                        companyName = it.companyName,
                        position = it.position,
                        startDate = it.startDate,
                        endDate = it.endDate,
                        currentPosition = it.currentPosition,
                        logo = it.logo,
                        description = it.description,
                        workType = it.workType
                    )
                )
            }
            return workList
        }
    }
}