package org.apache.activemq.openwire.v12;

import org.apache.activemq.command.ActiveMQFileMessage;
import org.apache.activemq.command.DataStructure;
import org.apache.activemq.openwire.BooleanStream;
import org.apache.activemq.openwire.OpenWireFormat;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ActiveMQFileMessageMarshaller extends ActiveMQMessageMarshaller{

    public byte getDataStructureType() {
        return ActiveMQFileMessage.DATA_STRUCTURE_TYPE;
    }

    public DataStructure createObject() {
        return new ActiveMQFileMessage();
    }

    public void tightUnmarshal(OpenWireFormat wireFormat, Object o, DataInput dataIn, BooleanStream bs) throws IOException {
        super.tightUnmarshal(wireFormat, o, dataIn, bs);
    }

    public int tightMarshal1(OpenWireFormat wireFormat, Object o, BooleanStream bs) throws IOException {

        int rc = super.tightMarshal1(wireFormat, o, bs);

        return rc + 0;
    }

    public void tightMarshal2(OpenWireFormat wireFormat, Object o, DataOutput dataOut, BooleanStream bs) throws IOException {
        super.tightMarshal2(wireFormat, o, dataOut, bs);

    }

    public void looseUnmarshal(OpenWireFormat wireFormat, Object o, DataInput dataIn) throws IOException {
        super.looseUnmarshal(wireFormat, o, dataIn);

    }

    public void looseMarshal(OpenWireFormat wireFormat, Object o, DataOutput dataOut) throws IOException {

        super.looseMarshal(wireFormat, o, dataOut);

    }
}
