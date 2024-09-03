import React, { useState } from 'react';
import { Box, Tab, Tabs, Typography } from '@mui/material';

const sortOptions = ['Cheapest', 'Best', 'Quickest'];

const sortItemTitlefontStyle = {
    fontFamily: 'Montserrat, sans-serif', // Font family
    fontWeight: '600', // Semibold
    fontSize: '16px', // Font size
    color: '#112211', // Text color
    textTransform: 'capitalize' // Capitalize only the first letter
};

const SortTabs = () => {
    const [selectedTab, setSelectedTab] = useState(0);

    const handleTabChange = (event, newValue) => {
        setSelectedTab(newValue);
    };

    return (
        <Box display="flex" alignItems="center" justifyContent="space-between" mb={2} style={{ backgroundColor: '#fff', padding: '8px', borderRadius: '15px', width: '100%', overflowX: 'auto' }}>
            <Tabs
                value={selectedTab}
                onChange={handleTabChange}
                indicatorColor="primary"
                textColor="primary"
                TabIndicatorProps={{
                    style: { backgroundColor: '#8DD3BB', height: '3px' },
                }}
                style={{ width: '100%' }} // Ensure Tabs take full width of the container
            >
                {sortOptions.map((option, index) => (
                    <Tab
                        key={index}
                        style={{
                            borderRight: index < sortOptions.length - 1 ? '1px solid #112211' : 'none',
                            flex: 1, // Ensure Tab takes up equal width
                            overflow: 'hidden' // Prevent overflow
                        }}
                        label={
                            <Box display="flex" flexDirection="column" alignItems="flex-start" style={{ width: '100%' }}>
                                <Typography variant="body1" style={sortItemTitlefontStyle}>
                                    {option}
                                </Typography>
                                <Typography
                                    style={{
                                        fontFamily: 'Montserrat, sans-serif',
                                        fontSize: '14px',
                                        color: '#112211',
                                        textTransform: 'capitalize'
                                    }}
                                >
                                    $99 . 2h 18m
                                </Typography>
                            </Box>
                        }
                    />
                ))}
            </Tabs>
        </Box>
    );
};

export default SortTabs;
