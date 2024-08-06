import React, { useEffect, useState } from 'react';
import Flatpickr from 'react-flatpickr';
import 'flatpickr/dist/flatpickr.min.css';
import Spinner from 'react-bootstrap/Spinner';
import { format } from 'date-fns';
// import Apis, { endpoint } from "../configs/Apis"
// import { Button, Card, Col, Container, Row, Spinner } from "react-bootstrap"
import { useNavigate } from "react-router-dom"
import Form from 'react-bootstrap/Form';
import { Button, Container } from 'react-bootstrap';
import Apis, { endpoint } from '../configs/Apis';
import ViewTrip from './ViewTrip';

const Home = () => {
    const nav = useNavigate()
    const [trip, setTrip] = useState({
        from: "5",
        to: "5",
        date: ""
    })
    const [station, setStation] = useState(null);
    const loadStation = async () => {
        try {
            const res = await Apis.get(endpoint['station']);
            setStation(res.data)
        }
        catch (ex) { console.error(ex) }
    }

    const findTrip = async (evt) => {
        evt.preventDefault();

        try {

            const res = await Apis.get(endpoint['trip'], {
                params: {
                    from: trip.from,
                    to: trip.to,
                    date: (trip.date)
                }
            });

        }
        catch (ex) { console.error(ex) }
        const message = "Hello from ParentComponent";
        < ViewTrip message={message}  />
        nav("/viewtrip");
        
    }

    const updateField = (field, value) => {
        setTrip(prevTrip => ({
            ...prevTrip,
            [field]: value
        }));
    };


    useEffect(() => {
        loadStation()


    }, []);
    if (station === null)
        return <Spinner animation="border" />;


    return (
        <>
            <Container>


                <Form.Label >Nơi đi: </Form.Label>
                <Form.Select className='mr-3' aria-label="Default select example"
                    value={trip.from}
                    onChange={(e) => updateField('from', e.target.value)}>
                    {station.map(s => <option value={s.id} >{s.name}</option>)}
                </Form.Select>

                <Form.Label >Nơi đến: </Form.Label>
                <Form.Select className='mr-3' aria-label="Default select example"
                    value={trip.to}
                    onChange={(e) => updateField('to', e.target.value)}>
                    {station.map(s => <option value={s.id} >{s.name}</option>)}
                </Form.Select>

                <Form.Label >Ngày đi: </Form.Label>
                <Flatpickr className='mr-3'
                    value={trip.date}
                    onChange={(selectedDates) => updateField('date', format(new Date(selectedDates[0]), 'yyyy-MM-dd'))}

                    options={{ dateFormat: 'Y-m-d', timeZone: "Asia/Ho_Chi_Minh" }} // Định dạng ngày
                />


                <Button onClick={findTrip} variant="warning">Tìm chuyến</Button>


            </Container >
        </>
    )
}


export default Home