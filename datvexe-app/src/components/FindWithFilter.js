import React, { useState, useEffect } from 'react';
import Footer from '../layout/Footer';
import TripCard from './TripCard';
import SearchForm from './SearchForm';
import { Filters } from './Filter';
import SortTab from './SortTab';
import { Typography, Button } from '@mui/material';
import { useLocation } from 'react-router-dom';
import Apis, { endpoint } from '../configs/Apis';


const trips = [];

const TripList = ({ tripsToShow }) => {
    console.log(trips)
    return (
        <div className="flights-list">
            {tripsToShow.map((trip, index) => (
                <TripCard key={index} {...trip} />
            ))}
        </div>
    );
};

const MainPage = () => {

    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);

    const fromProvince = queryParams.get('from') || '';
    const toProvince = queryParams.get('to') || '';
    const departureDate = queryParams.get('departureDate') || '';
    const numberOfTickets = queryParams.get('numberOfTickets') || '1';

    const tripsPerPage = 3;
    const [showMore, setShowMore] = useState(false);
    const displayedTrips = trips.slice(0, tripsPerPage);
   
    const [totalTrips, setTotalTrips] = useState(trips.length);
    const tripsToShow = showMore ? trips : displayedTrips;

    const [price, setPrice] = useState([50, 1200]);
    const [time, setTime] = useState([0, 24]);


    // Hàm để nhận giá trị price từ Filters
    const handlePriceChange = (newPrice) => {
        setPrice(newPrice);
    };

    // Hàm để nhận giá trị time từ Filters
    const handleTimeChange = (newTime) => {
        setTime(newTime);
    };

    const loadTrip = async () => {
        let form = new FormData()
        form.append("fromProvince", fromProvince)
        form.append("toProvince", toProvince)
        form.append("departureDate", departureDate)
        form.append("time", time)
        form.append("price", price)
        try {
            let res = await Apis.post(endpoint['trip'], form)
            trips.length = 0; // Xóa toàn bộ nội dung mảng hiện tại
            trips.push(...res.data); // Thêm phần tử mới vào mảng trips
           
            setTotalTrips(trips.length)
            
        }
        catch (err) {
            console.log(err)
        }
    }

    useEffect(() => {
        window.scrollTo(0, 700);
        loadTrip()

    }, [fromProvince, toProvince, departureDate, time, price]);


    return (
        <div style={{ backgroundColor: '#FAFBFC', fontFamily: 'Montserrat, sans-serif' }}>

            <div style={{ backgroundColor: '#FAFBFC', margin: '0 100px 100px 100px' }}>
                <SearchForm
                    style={{ marginTop: '50px' }}
                    initialFromProvince={fromProvince}
                    initialToProvince={toProvince}
                    initialDepartureDate={departureDate}
                    initialNumberOfTickets={numberOfTickets}

                />
                <div className="main-content" style={{ display: 'flex', marginTop: '20px', fontFamily: 'Montserrat, sans-serif', color: '#112211' }}>
                    <div className="filters-container" style={{ width: '25%' }}>
                        <Filters onPriceChange={handlePriceChange} onTimeChange={handleTimeChange} />
                    </div>
                    <div style={{ border: '1px solid #112211', marginRight: '25px' }}></div>
                    <div className="flights-list-container" style={{ width: '75%' }}>
                        <SortTab />
                        <Typography style={{ fontWeight: 'bold', margin: '15px' }}>
                            Showing {tripsToShow.length} of <span style={{ color: '#FF8682' }}>{totalTrips}</span> trips
                        </Typography>
                        <TripList tripsToShow={tripsToShow} />
                        {totalTrips > tripsPerPage && !showMore && (
                            <Button
                                style={{
                                    color: '#fff',
                                    backgroundColor: '#112211',
                                    width: '100%',
                                    padding: '8px',
                                    fontWeight: 'bold'
                                }}
                                onClick={() => setShowMore(true)}
                            >
                                Show more results
                            </Button>
                        )}
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
};

export default MainPage;
