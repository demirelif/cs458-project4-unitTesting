import React, { useState, useContext, useRef } from 'react';
import Header from '../components/header.js'
import { Form, Modal, DatePicker, Select, Button } from 'antd';
import 'antd/dist/antd.css';
import axios from 'axios';
import { Context } from '../Context';
import _ from 'lodash';
const { Option } = Select;

const EnterSymptoms = () => {
    const formRef = useRef(null)
    const [form] = Form.useForm();

    const [context, setContext] = useContext(Context);

    const [visible, setVisible] = useState(false);
    const [confirmLoading, setConfirmLoading] = useState(false);
    const [modalText, setModalText] = useState("");

    const handleOk = () => {
        setVisible(false);
    };

    const handleCancel = () => {
        console.log('Clicked cancel button');
        setVisible(false);
    };

    const onFinish = (values) => {
        setModalText("")
        setVisible(true);
        setConfirmLoading(true);
        const fields = formRef.current.getFieldsValue();
        console.log("Adad")
        console.log({ date: new Date(fields['date-picker']['_d']).toDateString() })
        //async bi request at, bekle

        axios.post(`http://localhost:8080/api/patient/sendsymptoms`, {
            authed_email: context.authed_email,
            date: new Date(fields['date-picker']['_d']).toDateString(),
            symptoms: _.map(fields['select-multiple'], (a)=>{return a.toUpperCase();})
        }).then((response) => {
            setConfirmLoading(false);
            setModalText("New data added")
        }).catch(function (error) {
            setConfirmLoading(false);
            setModalText("An error occured");
        });
    };

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 8 },
    };

    return (
        <div className="signin-wrapper">
             <Modal title="Enter symptoms" visible={visible}
                onOk={handleOk}
                confirmLoading={confirmLoading}
                onCancel={handleCancel}
            >
                <p>{modalText}</p>
            </Modal>
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
                ref={formRef}
            >
                <Form.Item name="date-picker" label="DatePicker">
                    <DatePicker format="DD-MM-YYYY" />
                </Form.Item>

                <Form.Item
                    name="select-multiple"
                    label="Select [multiple]"
                    rules={[{ required: true, message: 'Please select your symptoms', type: 'array' }]}
                >
                    <Select mode="multiple" placeholder="Please select your symptoms">
                        <Option value="fever" >fever</Option>
                        <Option value="cough">cough</Option>
                        <Option value="musclepain">musclepain</Option>
                        <Option value="nausea">nausea</Option>
                        <Option value="vomiting">vomiting</Option>
                        <Option value="diarrhea">diarrhea</Option>
                    </Select>
                </Form.Item>

                <Form.Item wrapperCol={{ ...layout.wrapperCol, offset: 8 }} >
                    <Button className="form-button" type="primary" htmlType="submit">
                        Submit
                    </Button>
                </Form.Item>
            </Form>
        </div>
    )
}

export default EnterSymptoms;