/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oap.server.core.analysis.generated.serviceinstancejvmgc;

import java.util.*;
import lombok.*;
import org.apache.skywalking.oap.server.core.Const;
import org.apache.skywalking.oap.server.core.alarm.AlarmMeta;
import org.apache.skywalking.oap.server.core.alarm.AlarmSupported;
import org.apache.skywalking.oap.server.core.analysis.indicator.*;
import org.apache.skywalking.oap.server.core.analysis.indicator.annotation.IndicatorType;
import org.apache.skywalking.oap.server.core.remote.annotation.StreamData;
import org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteData;
import org.apache.skywalking.oap.server.core.storage.annotation.*;
import org.apache.skywalking.oap.server.core.storage.StorageBuilder;
import org.apache.skywalking.oap.server.core.source.Scope;

/**
 * This class is auto generated. Please don't change this class manually.
 *
 * @author Observability Analysis Language code generator
 */
@IndicatorType
@StreamData
@StorageEntity(name = "instance_jvm_young_gc_time", builder = InstanceJvmYoungGcTimeIndicator.Builder.class)
public class InstanceJvmYoungGcTimeIndicator extends LongAvgIndicator implements AlarmSupported {

    @Setter @Getter @Column(columnName = "id") private int id;
    @Setter @Getter @Column(columnName = "service_instance_id") private int serviceInstanceId;

    @Override public String id() {
        String splitJointId = String.valueOf(getTimeBucket());
        splitJointId += Const.ID_SPLIT + String.valueOf(id);
        return splitJointId;
    }

    @Override public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (int)getTimeBucket();
        return result;
    }

    @Override public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        InstanceJvmYoungGcTimeIndicator indicator = (InstanceJvmYoungGcTimeIndicator)obj;
        if (id != indicator.id)
            return false;

        if (getTimeBucket() != indicator.getTimeBucket())
            return false;

        return true;
    }

    @Override public RemoteData.Builder serialize() {
        RemoteData.Builder remoteBuilder = RemoteData.newBuilder();

        remoteBuilder.setDataLongs(0, getSummation());
        remoteBuilder.setDataLongs(1, getValue());
        remoteBuilder.setDataLongs(2, getTimeBucket());


        remoteBuilder.setDataIntegers(0, getId());
        remoteBuilder.setDataIntegers(1, getServiceInstanceId());
        remoteBuilder.setDataIntegers(2, getCount());

        return remoteBuilder;
    }

    @Override public void deserialize(RemoteData remoteData) {

        setSummation(remoteData.getDataLongs(0));
        setValue(remoteData.getDataLongs(1));
        setTimeBucket(remoteData.getDataLongs(2));


        setId(remoteData.getDataIntegers(0));
        setServiceInstanceId(remoteData.getDataIntegers(1));
        setCount(remoteData.getDataIntegers(2));
    }

    @Override public AlarmMeta getAlarmMeta() {
        return new AlarmMeta("instance_jvm_young_gc_time", Scope.ServiceInstanceJVMGC, id, serviceInstanceId);
    }

    public static class Builder implements StorageBuilder<InstanceJvmYoungGcTimeIndicator> {

        @Override public Map<String, Object> data2Map(InstanceJvmYoungGcTimeIndicator storageData) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", storageData.getId());
            map.put("service_instance_id", storageData.getServiceInstanceId());
            map.put("summation", storageData.getSummation());
            map.put("count", storageData.getCount());
            map.put("value", storageData.getValue());
            map.put("time_bucket", storageData.getTimeBucket());
            return map;
        }

        @Override public InstanceJvmYoungGcTimeIndicator map2Data(Map<String, Object> dbMap) {
            InstanceJvmYoungGcTimeIndicator indicator = new InstanceJvmYoungGcTimeIndicator();
            indicator.setId(((Number)dbMap.get("id")).intValue());
            indicator.setServiceInstanceId(((Number)dbMap.get("service_instance_id")).intValue());
            indicator.setSummation(((Number)dbMap.get("summation")).longValue());
            indicator.setCount(((Number)dbMap.get("count")).intValue());
            indicator.setValue(((Number)dbMap.get("value")).longValue());
            indicator.setTimeBucket(((Number)dbMap.get("time_bucket")).longValue());
            return indicator;
        }
    }
}
