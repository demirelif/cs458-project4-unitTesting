import React,{useState,useEffect} from 'react';
import Header from '../components/header.js'
import { Form, DatePicker, Select, Button } from 'antd';
import 'antd/dist/antd.css';
const { Option } = Select;

const EnterSymptoms = () => {
    const [selected, setSelected] = useState([])
    const [form] = Form.useForm();

    const responseMockup = {
        authed_username: "artun",
        symptoms: ["muscle", "fever"]
    }

    useEffect(()=>{
        console.log(selected)
    },[selected])

    
    const onFinish = (values) => {
        // values["date-picker"]["_d"]
        console.log('Success:', values);
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    const layout = {
        labelCol: { span: 8 },
        wrapperCol: { span: 8 },
    };

    const newSelect = () => {
        console.log(selected);
    }

    return (
        <div className="signin-wrapper">
            <Form {...layout}
                name="basic"
                initialValues={{ remember: true }}
                onFinish={onFinish}
                onFinishFailed={onFinishFailed}

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
                        <Option value="muscle">muscle pain</Option>
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