import React, { useState, useEffect } from 'react';
import {
    Container,
    Grid,
    TextField,
    InputAdornment,
    Button,
    MenuItem,
    Select,
    InputLabel,
    FormControl
} from '@mui/material';
import SwapHorizIcon from '@mui/icons-material/SwapHoriz';
import SearchIcon from '@mui/icons-material/Search';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SearchForm = ({ 
    style, 
    initialFromProvince = '', 
    initialToProvince = '', 
    initialDepartureDate = '', 
    initialNumberOfTickets = 1 
}) => {
    const [provinces, setProvinces] = useState([]);
    const [fromProvince, setFromProvince] = useState(initialFromProvince);
    const [toProvince, setToProvince] = useState(initialToProvince);
    const [today, setToday] = useState(initialDepartureDate);
    const [numberOfTickets, setNumberOfTickets] = useState(initialNumberOfTickets);
    const navigate = useNavigate();

    const getCurrentDate = () => {
        const now = new Date();
        const year = now.getFullYear();
        const month = String(now.getMonth() + 1).padStart(2, '0');
        const day = String(now.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    };

    const searchOnClick = () => {
        const searchParams = new URLSearchParams({
            from: fromProvince,
            to: toProvince,
            departureDate: today,
            numberOfTickets: numberOfTickets
        }).toString();

        navigate(`/search?${searchParams}`);
    };

    useEffect(() => {
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

    useEffect(() => {
        setToday(getCurrentDate());
    }, []);

    return (
        <Container maxWidth="lg" style={{ borderRadius: '15px', padding: '25px 15px', backgroundColor: 'white', ...style }}>
           
            <Grid container spacing>
                <Grid item xs={12}>
                    <Grid container spacing>
                        <Grid item xs={12} container spacing alignItems="center" justifyContent="center">
                            <Grid item xs>
                                <FormControl fullWidth>
                                    <InputLabel>From</InputLabel>
                                    <Select
                                        value={fromProvince}
                                        onChange={(e) => setFromProvince(e.target.value)}
                                        label="From"
                                    >
                                        {provinces.map((province) => (
                                            <MenuItem key={province.code} value={province.code}>
                                                {province.name}
                                            </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>
                            </Grid>
                            <Grid item xs={1} container alignItems="center" justifyContent="center">
                                <InputAdornment position="start">
                                    <SwapHorizIcon />
                                </InputAdornment>
                            </Grid>
                            <Grid item xs>
                                <FormControl fullWidth>
                                    <InputLabel>To</InputLabel>
                                    <Select
                                        value={toProvince}
                                        onChange={(e) => setToProvince(e.target.value)}
                                        label="To"
                                    >
                                        {provinces.map((province) => (
                                            <MenuItem key={province.code} value={province.code}>
                                                {province.name}
                                            </MenuItem>
                                        ))}
                                    </Select>
                                </FormControl>
                            </Grid>
                            <Grid item xs>
                                <TextField
                                    label="Departure date"
                                    value={today}
                                    fullWidth
                                    type="date"
                                    InputProps={{
                                        inputProps: {
                                            min: today,
                                        },
                                    }}
                                    InputLabelProps={{
                                        shrink: true,
                                    }}
                                    onChange={(e) => setToday(e.target.value)}
                                />
                            </Grid>
                            <Grid item xs>
                                <TextField
                                    label="Number tickets"
                                    value={numberOfTickets}
                                    inputMode='numeric'
                                    type='number'
                                    fullWidth
                                    onChange={(e) => setNumberOfTickets(e.target.value)}
                                />
                            </Grid>
                        </Grid>
                        <Grid item xs={12} container spacing alignItems="center" justifyContent="flex-end">
                            <Grid item xs={2}>
                                <Button onClick={searchOnClick} variant="contained" color="primary" fullWidth style={{ backgroundColor: '#8DD3BB', padding: '0px' }}>
                                    <span><p style={{ textAlign: 'center', margin: '10px 15px', fontWeight: 'bold' }}>Find Trip</p></span>
                                    <span style={{ alignItems: 'center' }}><SearchIcon style={{ color: 'white' }} /></span>
                                </Button>
                            </Grid>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </Container>
    );
};

export default SearchForm;
