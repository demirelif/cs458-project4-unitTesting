import React, { useContext, useState } from 'react';
import { Context } from '../Context'
import Header from '../components/header.js'
import { Form, Input, Button, Modal, Select } from 'antd';
import 'antd/dist/antd.css';
import { Redirect } from 'react-router';
const { Option } = Select;


const SignIn = () => {

    const responseMockup = {auth:true, message: "bla bla"}

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
        setVisible(true);
        setConfirmLoading(true);
        //async bi request at, bekle
        //on get response
        if (responseMockup.auth) {
            setContext({ "authed": true });
            setModalText("Successfully logged in");
        } else {
            setContext({ "authed": false });
            setModalText(responseMockup.message);
        }
        setConfirmLoading(false);
        console.log(context);
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
                tex>
                <p>{modalText}</p>
            </Modal>
            {context.authed &&
                <Redirect to="/entersymptoms" />
            }
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
            >
                <Form.Item
                    label="Username"
                    name="username"
                    rules={[{ required: true, message: 'Please input your username!' }]}
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