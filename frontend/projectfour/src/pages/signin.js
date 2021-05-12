import React, { useContext } from 'react';
import { Context } from '../Context'
import Header from '../components/header.js'
import { Form, Input, Button, Checkbox, Select, InputNumber } from 'antd';
import 'antd/dist/antd.css';
import { Redirect } from 'react-router';
const { Option } = Select;


const SignIn = () => {
    const [form] = Form.useForm();

    const [context, setContext] = useContext(Context);

    const onFinish = (values) => {
        console.log('Success:', values);
        if (values.username === "artun" && values.password === "123123") {
            setContext({ "authed": true });
            console.log("WIUU");
        } else {
            setContext({ "authed": false });
        }
        console.log(context);
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 8 },
    };

    return (
        <div className="signin-wrapper">
            {context.authed &&
                    <Redirect to="/entersymptoms" />
            }
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
                onFinishFailed={onFinishFailed}

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