import React  from "react";
import './TopSlider.css';

const TopSlider = props => {

    return (
      
        <img className="mySlides" src={props.image} style={{ width: "100%" }} />
    
    );

};
export default TopSlider;
