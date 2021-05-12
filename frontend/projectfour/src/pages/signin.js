import React, { useContext, useRef, useState } from 'react';
import { Context } from '../Context'
import Header from '../components/header.js'
import { Form, Input, Button, Modal, Select } from 'antd';
import 'antd/dist/antd.css';
import { Redirect } from 'react-router';
import axios from 'axios'
const { Option } = Select;


const SignIn = () => {
    const formRef = useRef(null)

    const responseMockup = { auth: true, message: "bla bla" }

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
        const fields = formRef.current.getFieldsValue()
        //async bi request at, bekle
        axios.get(`http://localhost:8080/api/patient/login?email=${fields.email}&password=${fields.password}`)
            .then((response) => {
                console.log(response);
                if (response.data.auth) {
                    setContext({ "authed": true });
                    setModalText("Successfully logged in");
                } else {
                    setContext({ "authed": false });
                    setModalText(response.data.message);
                }
                setConfirmLoading(false);
            }).catch(function (error) {
                console.log(error);
                setConfirmLoading(false);
                setModalText("Connection Error")
            });
        //on get response
    };

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 8 },
    };

    return (
        <div className="signin-wrapper">
            <Modal title="Basic Modal" visible={visible}
                onOk={handleOk}
                confirmLoading={confirmLoading}
                onCancel={handleCancel}
            >
                <p>{modalText}</p>
            </Modal>
            {context.authed &&
                <Redirect to="/entersymptoms" />
            }
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
                ref={formRef}
            >
                <Form.Item
                    label="Email"
                    name="email"
                    rules={[{ type:'email', required: true, message: 'Please input your username!' }]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    label="Password"
                    name="password"
                    rules={[{ required: true, message: 'Please input your password!' }]}
                >
                    <Input.Password />
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

export default SignIn;