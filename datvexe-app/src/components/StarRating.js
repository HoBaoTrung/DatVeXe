import React, { useState } from 'react';
import '../static/StarRating.css'; // Đừng quên tạo file CSS tương ứng

const StarRating = ({ totalStars = 5, onRate }) => {
  const [rating, setRating] = useState(0);
  const [hoveredStar, setHoveredStar] = useState(null);

  const handleMouseEnter = (index) => {
    setHoveredStar(index);
  };

  const handleMouseLeave = () => {
    setHoveredStar(null);
  };

  const handleClick = (index) => {
    setRating(index);
    if (onRate) {
      onRate(index); // Gọi callback khi có đánh giá mới
    }
  };

  return (
    <div>
      <div className="star-rating">
        {[...Array(totalStars)].map((_, index) => {
          const starIndex = index + 1;
          return (
            <span
              key={starIndex}
              className={`star ${starIndex <= (hoveredStar || rating) ? 'filled' : ''}`}
              onMouseEnter={() => handleMouseEnter(starIndex)}
              onMouseLeave={handleMouseLeave}
              onClick={() => handleClick(starIndex)}
            >
              ★
            </span>
          );
        })}
      </div>
      <div className="rating-result">
        {rating > 0 && <p>Bạn đã đánh giá {rating} sao</p>}
      </div>
    </div>
  );
};

export default StarRating;
