import React from "react";
import './SuperPick.css';


const SuperPick = props => {

    return (
     
        <div className=" w3-col s12 m4 l4 w3-hover-opacity w3-margin-bottom">
          <img src={props.image} className="collection" style={{ width: "100%" }} />
        </div>
    
    );
 
};

export default SuperPick;
