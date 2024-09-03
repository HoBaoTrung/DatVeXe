import React from 'react';
import { Image } from 'react-bootstrap';
import Header from '../layout/Header';
import Footer from '../layout/Footer';
import headerImage from '../assets/home-header-image.png';
import SearchForm from './SearchForm'; // Đảm bảo tên import chính xác

const Home = () => {
    return (
        <div style={{ position: 'relative', textAlign: 'center', backgroundColor:'#FAFBFC' }}>
            <Header isTransparentBackground={true} />
            
            {/* Image background */}
            <Image 
                src={headerImage} 
                fluid 
                style={{ 
                    width: '-webkit-fill-available', // Đảm bảo hình ảnh chiếm toàn bộ chiều rộng màn hình,
                    margin:'20px'
                }}
            />
            
            {/* Container to center FindTrip */}
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

            <Footer />
        </div>
    );
};

export default Home;
