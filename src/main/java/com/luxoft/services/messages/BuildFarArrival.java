package com.luxoft.services.messages;

import com.luxoft.dto.FarArrivalDto;
import com.luxoft.model.Resource;
import com.luxoft.model.Wagon;
import com.luxoft.rest.SchemaValues;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;

@Component
@RequiredArgsConstructor
public class BuildFarArrival {
    private  FarArrivalDto.Pk pk = new FarArrivalDto.Pk();
    private  FarArrivalDto.Data data = new FarArrivalDto.Data();
    private  List<FarArrivalDto.Position> positionList = new ArrayList<>();

    private final FarArrivalDto model = new FarArrivalDto();

    public FarArrivalDto configureModel(Resource resource, List<Wagon> wagonList)  {
        model.setValueSchema(SchemaValues.FAR_ARRIVAL_SCHEMA.getSchema());
        FarArrivalDto.Value value = new FarArrivalDto.Value();
        value.setTs(getCurrentTimeStamp());
        value.setOp("I");
        value.setPk(pk);
        value.setData(data);
        List<FarArrivalDto.Record> records = new ArrayList<>();
        FarArrivalDto.Record record = new FarArrivalDto.Record();
        record.setValue(value);
        records.add(record);
        model.setRecords(records);
        setPk("СР402715", "2021-11-16T15:58:59+06:00");
        setData(resource);
        configureTrain(wagonList);
        return model;
    }

    private void setPk(String wayBillNumber, String departureDate) {
        pk.setDepartureDate(departureDate);
        pk.setWaybillNum(wayBillNumber);
    }

    private void setData(Resource resource) {
        data.setSupplierCode(resource.getSupplierCode());
        data.setStationDepartureCode("2200");
        data.setStationArrivalCode("5221");
        data.setStationArrivalName("ВХОДНАЯ");
        data.setStationDepartureName("ЗАРИНСКАЯ");
        data.setSupplierName(resource.getSupplierName());
        data.setMaterialCode(resource.getMaterialCode());
        data.setMaterialName(resource.getMaterialName());
        data.setPositions(positionList);
    }

    private void configureTrain(List<Wagon> wagonList){
        for (Wagon wagon : wagonList) {
            FarArrivalDto.Position position = new FarArrivalDto.Position();
            position.setWagonNum(Integer.parseInt(wagon.getVehicleNumber()));
            position.setWeightNet(wagon.getWeightNet());
            position.setWagonType(wagon.getWagonType());
            positionList.add(position);
        }
    }


}
