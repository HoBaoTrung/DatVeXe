import React, { useState } from 'react';
import {
    Accordion,
    AccordionSummary,
    AccordionDetails,
    Slider,
    Typography,
    Box,
    Button
} from '@mui/material';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

// Define styles for Accordion
const removeBorderOfFilterItem = {
    backgroundColor: '#FAFBFC', // Background color
    boxShadow: 'none', // Removes the default shadow
    border: 'none', // Removes the border
    '&::before': {
        display: 'none', // Hides the default border for the accordion
    }
};

const filterItemStyle = {
    padding: '0px',
};

const filterItemTitleStyle = {
    fontWeight: 'bold'
}

const rangeSliderStyle = {
    color: '#112211', // Slider track color (default track color when not selected)
    height: '1px',
    '& .MuiSlider-thumb': {
        backgroundColor: '#8DD3BB', // Thumb color
        border: '2px solid #FFF', // Thumb border color
        width: 24,
        height: 24,
        '&:hover': {
            boxShadow: '0 0 0 8px rgba(141, 211, 115, 0.16)',
        },
    }
};

const accordionDetailsStyle = {
    borderBottom: '1px solid #E0E0E0', // Add bottom border for the expanded state
};


const Filters = ({ onPriceChange, onTimeChange }) => {
    const [price, setPrice] = useState([50, 1200]);
    const [time, setTime] = useState([0, 24]);

    const handlePriceChange = (event, newValue) => {
        setPrice(newValue);
       
        
    };

    const handlePriceChangeCommitted = (event, newValue) => {
         // Giá trị cuối cùng sau khi thả chuột
        onPriceChange(newValue); 
    };

    const handleTimeChange = (event, newValue) => {
        setTime(newValue);
       
    };

    const handleTimeChangeCommitted = (event, newValue) => {
         // Giá trị cuối cùng sau khi thả chuột
        onTimeChange(newValue); 
    };

    return (
        <div className="filters" style={{ marginRight: '25px', backgroundColor: '#FAFBFC', padding: '16px', borderRadius: '8px' }}>
            <Typography variant="h6" style={{ fontWeight: 'bold' }}>Filters</Typography>

            {/* Price Filter */}
            <Accordion style={removeBorderOfFilterItem} defaultExpanded>
                <AccordionSummary expandIcon={<ExpandMoreIcon />} style={filterItemStyle}>
                    <Typography style={filterItemTitleStyle}>Price</Typography>
                </AccordionSummary>
                <AccordionDetails style={accordionDetailsStyle}>
                    <Slider
                        value={price}
                        onChangeCommitted={handlePriceChangeCommitted}
                        onChange={handlePriceChange}
                        valueLabelDisplay="auto"
                        min={50}
                        max={1200}
                        marks={[{ value: 50, label: '50k' }, { value: 1200, label: '1200k' }]}
                        sx={rangeSliderStyle}
                    />
                </AccordionDetails>
            </Accordion>

            {/* Departure Time Filter */}
            <Accordion style={removeBorderOfFilterItem} defaultExpanded>
                <AccordionSummary expandIcon={<ExpandMoreIcon />} style={filterItemStyle}>
                    <Typography style={filterItemTitleStyle}>Departure Time</Typography>
                </AccordionSummary>
                <AccordionDetails style={accordionDetailsStyle}>
                    <Slider
                        value={time}
                        onChange={handleTimeChange}
                        onChangeCommitted={handleTimeChangeCommitted}
                        valueLabelDisplay="auto"
                        min={0}
                        max={24}
                        marks={[{ value: 0, label: '12:01 AM' }, { value: 24, label: '11:56 PM' }]}
                        sx={rangeSliderStyle}
                    />
                </AccordionDetails>
            </Accordion>

            {/* Rating Filter */}
            <Accordion style={removeBorderOfFilterItem} defaultExpanded>
                <AccordionSummary expandIcon={<ExpandMoreIcon />} style={filterItemStyle}>
                    <Typography style={filterItemTitleStyle}>Rating</Typography>
                </AccordionSummary>
                <AccordionDetails style={accordionDetailsStyle}>
                    <Box display="flex" justifyContent="space-between" >
                        {[0, 1, 2, 3, 4].map((rating) => (
                            <Button
                                variant="outlined"
                                key={rating}
                                size="small" // Adjust the size here
                                style={{
                                    margin: '0 5px', // Adjusted margin to provide space between buttons
                                    border: '1px solid #8DD3BB',
                                    color: '#112211',
                                    fontSize: '0.75rem', // Adjust font size
                                    padding: '4px 8px', // Adjust padding to control button size
                                    width: 'auto', // Let the button width adjust to content
                                    minWidth: '40px', // Set a minimum width if needed
                                    textAlign: 'center' // 
                                }}>
                                {rating}+
                            </Button>
                        ))}
                    </Box>
                </AccordionDetails>
            </Accordion>
        </div>
    );
};
export { Filters };
