import React, {useState, setContext, useRef} from 'react';
import Header from '../components/header.js'
import { Form, Input, Button, Modal, Select, InputNumber } from 'antd';
import 'antd/dist/antd.css';
import './signup.css'
import axios from 'axios';
const { Option } = Select;

const SignUp = () => {
    const formRef = useRef(null)

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
        setModalText("")
        setVisible(true);
        setConfirmLoading(true);
        const formData = formRef.current.getFieldsValue()
        //async bi request at, bekle
        axios.post('http://localhost:8080/api/patient/signup',{
            name: formData.name,
            surname: formData.surname,
            gender: formData.gender,
            age:formData.user.age,
            password:formData.password,
            email:formData.email
        }).then(response=>{
            if (response.data.signed) {
                setModalText("Successfully signed in");
            } else {
                setModalText(responseMockup.message);
            }
            setConfirmLoading(false);
        }).catch((e)=>{
            console.log(e)
            setConfirmLoading(false);
            setModalText("Connection Error")
        })
        //on get response
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
                ref={formRef}
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