package etlflow

import etlflow.etljobs.EtlJob
import etlflow.jobs._
import etlflow.MyEtlJobName._
import etlflow.utils.GlobalProperties

object LoadData extends EtlJobApp[MyEtlJobName[EtlJobProps], EtlJobProps, GlobalProperties] with TestSuiteHelper {

  override def globalProperties: Option[GlobalProperties] = Some(global_props)
  override def toEtlJob(job_name: MyEtlJobName[EtlJobProps]): (EtlJobProps, Option[GlobalProperties]) => EtlJob = {
    job_name match {
      case EtlJob1 => EtlJob1Definition
      case EtlJob2 => EtlJob2Definition
    }
  }
}
