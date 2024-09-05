// Spinner.js
import React from 'react';

const spinnerStyle = {
  border: '16px solid #f3f3f3', /* Light grey */
  borderTop: '16px solid #3498db', /* Blue */
  borderRadius: '50%',
  width: '20px',
  height: '20px',
  animation: 'spin 2s linear infinite',
  margin: '0 auto',
};

const keyframes = `
@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
`;

const Spinner = () => {
  return (
    <div>
      <style>{keyframes}</style>
      <div style={spinnerStyle}></div>
    </div>
  );
};

export default Spinner;
