import React, { useState, useEffect } from 'react';
import Header from '../layout/Header';
import Footer from '../layout/Footer';
import TripCard from './TripCard';
import SearchForm from './SearchForm';
import Filters from './Filter';
import SortTab from './SortTab';
import { Typography, Button } from '@mui/material';
import { useLocation } from 'react-router-dom';
import axios from 'axios';

const trips = [
    {
        carLogo: '../assets/bus-image.jpg',
        carName: 'Emirates',
        price: '$104',
        departureTime: '9:00 PM',
        arrivalTime: '01:28 PM',
        duration: '2h 28m'
    },
    {
        carLogo: '../assets/bus-image.jpg',
        carName: 'Flydubai',
        price: '$104',
        departureTime: '10:00 PM',
        arrivalTime: '01:28 PM',
        duration: '2h 28m'
    },
    {
        carLogo: '../assets/bus-image.jpg',
        carName: 'Qatar',
        price: '$104',
        departureTime: '12:00 PM',
        arrivalTime: '03:28 PM',
        duration: '2h 28m'
    },
    {
        carLogo: '../assets/bus-image.jpg',
        carName: 'Etihad',
        price: '$104',
        departureTime: '3:00 PM',
        arrivalTime: '05:28 PM',
        duration: '2h 28m'
    },
    // Add more trips here if needed
];

const TripList = ({ tripsToShow }) => {
    return (
        <div className="flights-list">
            {tripsToShow.map((trip, index) => (
                <TripCard key={index} {...trip} />
            ))}
        </div>
    );
};

const MainPage = () => {
    const [provinces, setProvinces] = useState([]);
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);

    const fromProvince = queryParams.get('from') || '';
    const toProvince = queryParams.get('to') || '';
    const departureDate = queryParams.get('departureDate') || '';
    const numberOfTickets = queryParams.get('numberOfTickets') || '1';

    const tripsPerPage = 3;
    const [showMore, setShowMore] = useState(false);
    const displayedTrips = trips.slice(0, tripsPerPage);
    const totalTrips = trips.length;
    const tripsToShow = showMore ? trips : displayedTrips;

    useEffect(() => {
        window.scrollTo(0, 0);
        axios.get('https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json')
            .then(response => {
                const data = response.data;
                const provincesList = data.map(item => ({
                    code: item.Id,
                    name: item.Name
                }));
                setProvinces(provincesList);
            })
            .catch(error => console.error('Error fetching provinces:', error));
    }, []);

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
                        <Filters />
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
