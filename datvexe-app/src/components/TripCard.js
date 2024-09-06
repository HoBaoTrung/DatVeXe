import React from 'react';
import { Card, CardContent, Typography, Button, CardMedia, Box } from '@mui/material';

// Đổi tên thành phần từ tripCard thành TripCard
const TripCard = ({ carImage, carNumber, price, departureTime, departureDate, nameCarType }) => {
    // Inline styles using MUI Box
    const tripCardStyle = {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '16px',
        marginBottom: '20px',
        border: '1px solid #ddd',
        borderRadius: '8px',
        backgroundColor: 'white',
        boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)',
        maxWidth: '100%',
    };

    const tripInfoStyle = {
        display: 'flex',
        alignItems: 'center',
        flexGrow: 1,
    };

    const carLogoStyle = {
        width: '50px',
        height: '50px',
        marginRight: '16px',
        objectFit: 'cover',
    };

    const tripDetailsStyle = {
        display: 'flex',
        flexDirection: 'column',
    };

    const carNameStyle = {
        margin: '0',
        fontSize: '18px',
        fontWeight: 'bold',
    };

    const tripTimeStyle = {
        fontSize: '14px',
        color: '#666',
    };

    const departureTimeStyle = {
        fontWeight: 'bold',
    };

    const arrivalTimeStyle = {
        fontWeight: 'bold',
    };

    const tripDurationStyle = {
        fontSize: '14px',
        color: '#999',
        marginTop: '4px',
    };

    const tripPriceStyle = {
        textAlign: 'right',
    };

    const priceStyle = {
        fontSize: '24px',
        fontWeight: 'bold',
        margin: '0',
        color: '#4CAF50',
    };

    const viewDetailsButtonStyle = {
        backgroundColor: '#4CAF50',
        color: 'white',
        padding: '10px 20px',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        fontSize: '14px',
        fontWeight: 'bold',
        transition: 'background-color 0.3s',
    };

    const viewDetailsButtonHoverStyle = {
        backgroundColor: '#45a049',
    };

    return (
        <Card sx={tripCardStyle}>
            <CardContent sx={tripInfoStyle}>
                <CardMedia
                    component="img"
                    image={carImage}
                    alt={`${carNumber} logo`}
                    sx={carLogoStyle}
                />
                <Box sx={tripDetailsStyle}>
                    <Typography variant="h6" sx={carNameStyle}>
                        {carNumber}
                    </Typography>
                    <Typography sx={tripTimeStyle}>
                        <span style={arrivalTimeStyle}>{departureDate}</span>
                        <span> - </span>
                        <span style={departureTimeStyle}>{departureTime}</span> 
                    </Typography>
                    <Typography sx={tripDurationStyle}>
                        {nameCarType}
                    </Typography>
                </Box>
            </CardContent>
            <CardContent sx={tripPriceStyle}>
                <Typography>Starting from</Typography>
                <Typography variant="h5" sx={priceStyle}>
                    {price}
                </Typography>
                <Button
                    sx={viewDetailsButtonStyle}
                    onMouseOver={(e) => e.currentTarget.style.backgroundColor = viewDetailsButtonHoverStyle.backgroundColor}
                    onMouseOut={(e) => e.currentTarget.style.backgroundColor = viewDetailsButtonStyle.backgroundColor}
                >
                    View Details
                </Button>
            </CardContent>
        </Card>
    );
};

export default TripCard;
