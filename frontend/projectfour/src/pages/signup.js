import React, {useState, setContext} from 'react';
import Header from '../components/header.js'
import { Form, Input, Button, Modal, Select, InputNumber } from 'antd';
import 'antd/dist/antd.css';
import './signup.css'
const { Option } = Select;

const SignUp = () => {
    const [form] = Form.useForm();

    const responseMockup = {signed:false,
        message: "Hatanin sebebi maildir"} 
       
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
        if (responseMockup.signed) {
            setModalText("Successfully signed in");
        } else {
            setModalText(responseMockup.message);
        }
    };

    const onGenderChange = (value) => {
    };


    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 8 },
    };

    return (
        <div className="signup-wrapper">
             <Modal title="Basic Modal" visible={visible}
                onOk={handleOk}
                confirmLoading={confirmLoading}
                onCancel={handleCancel}
                tex>
                <p>{modalText}</p>
            </Modal>
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}

            >
                 <Form.Item
                    label="Email"
                    name="email"
                    rules={[{ type: 'email', required: true, message: 'Please input your email!' }]}
                >
                    <Input />
                </Form.Item>

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

                <Form.Item
                    label="Name"
                    name="name"
                    rules={[{ required: true, message: 'Please input your name!' }]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    label="Surname"
                    name="surname"
                    rules={[{ required: true, message: 'Please input your surname!' }]}
                >
                    <Input />
                </Form.Item>

                <Form.Item name={['user', 'age']} label="Age" rules={[{ required:true,type: 'number', min: 0, max: 99 }]}>
                    <InputNumber />
                </Form.Item>

                <Form.Item name="gender" label="Gender" rules={[{ required: true }]}>
                    <Select
                        placeholder="Please select your gender"
                        onChange={onGenderChange}
                        allowClear
                    >
                        <Option value="male">male</Option>
                        <Option value="female">female</Option>
                        <Option value="other">other</Option>
                    </Select>
                </Form.Item>

                <Form.Item  wrapperCol={{ ...layout.wrapperCol, offset: 8 }} >
                    <Button className="form-button" type="primary" htmlType="submit">
                        Submit
                    </Button>
                </Form.Item>
            </Form>
        </div>
    )
}

export default SignUp;