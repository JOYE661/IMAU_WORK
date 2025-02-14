package org.apache.activemq.command;

import jakarta.jms.JMSException;
import jakarta.jms.MessageNotWriteableException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.util.ByteArrayOutputStream;
import org.apache.activemq.util.ByteSequence;
import org.apache.activemq.util.JMSExceptionSupport;
import org.apache.activemq.util.MarshallingSupport;
import org.apache.activemq.wireformat.WireFormat;

import java.io.*;
import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;

public class ActiveMQFileMessage extends ActiveMQMessage{
    public static final byte DATA_STRUCTURE_TYPE = CommandTypes.ACTIVEMQ_FILE_MESSAGE;

    protected File file;

    @Override
    public Message copy() {
        ActiveMQFileMessage copy = new ActiveMQFileMessage();
        copy(copy);
        return copy;
    }

    private void copy(ActiveMQFileMessage copy) {
        super.copy(copy);
        copy.file = file;
    }

    @Override
    public byte getDataStructureType() {
        return DATA_STRUCTURE_TYPE;
    }

    public void setFile(File file) throws MessageNotWriteableException {
        checkReadOnlyBody();
        this.file = file;
        setContent(null);
    }

    public File getFile() throws JMSException {
        ByteSequence content = getContent();

        if (file == null && content != null) {
            file = decodeContent(content);
            setContent(null);
            setCompressed(false);
        }
        return file;
    }

    private File decodeContent(ByteSequence bodyAsBytes) throws JMSException {
        File file = null;
        if (bodyAsBytes != null) {
            FileOutputStream fos = null;
            try {
                file = new File("");
                fos = new FileOutputStream(file);
                fos.write(bodyAsBytes.getData(), bodyAsBytes.getOffset(), bodyAsBytes.getLength());
            } catch (IOException ioe) {
                throw JMSExceptionSupport.create(ioe);
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        // ignore
                    }
                }
            }
        }
        return file;
    }

    @Override
    public void beforeMarshall(WireFormat wireFormat) throws IOException {
        super.beforeMarshall(wireFormat);
        storeContentAndClear();
    }

    @Override
    public void storeContentAndClear() {
        storeContent();
        file=null;
    }

    @Override
    public void storeContent() {
        try {
            ByteSequence content = getContent();
            File file = this.file; // 假设有一个File对象引用
            if (content == null && file != null) {
                ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
                OutputStream os = bytesOut;
                ActiveMQConnection connection = getConnection();
                if (connection != null && connection.isUseCompression()) {
                    compressed = true;
                    os = new DeflaterOutputStream(os);
                }
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024]; // 读取文件的缓冲区
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead); // 将文件内容写入输出流
                }
                fis.close(); // 关闭文件输入流
                os.close(); // 关闭输出流
                setContent(bytesOut.toByteSequence()); // 将输出流的内容设置为消息的内容
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clearUnMarshalledState() throws JMSException {
        super.clearUnMarshalledState();
        this.file = null;
    }

    @Override
    public boolean isContentMarshalled() {
        return content != null || file == null;
    }

    @Override
    public void clearBody() throws JMSException {
        super.clearBody();
        this.file = null;
    }

    @Override
    public int getSize() {
        File file = this.file;
        if (size == 0 && content == null && file != null) {
            size = getMinimumMessageSize();
            if (marshalledProperties != null) {
                size += marshalledProperties.getLength();
            }
            size += file.length();
        }
        return super.getSize();
    }

    @Override
    public String toString() {
        try {
            String fileDetails = this.file.getAbsolutePath();  // 假设存在一个获取文件路径的方法
            if (fileDetails != null) {
                HashMap<String, Object> overrideFields = new HashMap<String, Object>();
                overrideFields.put("fileDetails", fileDetails);
                return super.toString(overrideFields);
            }
        } catch (Exception e) {
        }
        return super.toString();
    }

    @SuppressWarnings("unchecked")
    public boolean isBodyAssignableTo(Class c) throws JMSException {
        if (getFile() == null) {
            return true;
        }
        return c.isAssignableFrom(File.class);
    }

    @SuppressWarnings("unchecked")
    protected <T> T doGetBody(Class<T> asType) throws JMSException {
        return (T) getFile();
    }
}
