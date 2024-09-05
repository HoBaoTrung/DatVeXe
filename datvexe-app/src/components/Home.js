import React from 'react';
import SearchForm from './SearchForm'; // Đảm bảo tên import chính xác

const Home = () => {
    return (
      
        <div style={{ position: 'relative', textAlign: 'center', backgroundColor:'#FAFBFC' }}>
          
            <div style={{
                display: 'flex', // Sử dụng Flexbox để căn giữa
                justifyContent: 'center', // Căn giữa theo chiều ngang
                margin: '20px 0', // Thêm khoảng cách trên và dưới
            }}>
                {/* FindTrip Component */}
                <div style={{
                    transform: 'translateY(-50%)',
                    width: '80%', // Điều chỉnh chiều rộng của FindTrip
                    backgroundColor: 'white', // Nếu muốn background trắng cho FindTrip
                    borderRadius: '8px', // Tùy chọn để bo góc của FindTrip
                    padding: '10px', // Padding cho FindTrip
                }}>
                    <SearchForm />
                   
                </div>
                
            </div>

          
        </div>
    );
};

export default Home;
