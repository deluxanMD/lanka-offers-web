import React from "react";
import './FooterTop.css';


const FooterTop = () =>{

    return (
      <div>
       

        <footer className="w3-row-padding w3-padding-32" id="footer1strow">
          <div className="w3-col s12 m12 l4" style={{ textAlign: "justify" }}>
            <h3 id="footer1strow" className="w3-center">About Lanka Offers</h3>
            <p>
              Lanka Offers brings you discounted offers on awesome things to
              eat, do, see, and experience in your city – all from a single,
              convenient mobile app!Browse through thousands of FaveDeals and
              save up to 80% at your favourite restaurants, cafés, spas, salons,
              gyms, retail stores, and more. Or pay your bills quickly and
              easily with FavePay and get rewarded with up to 30% cashback.
            </p>
          </div>
          <div className=" w3-col s12 m6 l4">
            <h3 id="footer1strow">Links</h3>
            <p>
              <a className="w3-margin  ">Careers</a>{" "}
              <a className="w3-margin">Partners</a>{" "}
              <a className="w3-margin  ">Contact Us</a>{" "}
              <a className="w3-margin">Privacy Policy</a>{" "}
              <a className="w3-margin ">Legal</a>{" "}
            </p>
          </div>
   
          <div className="w3-col s12 m16 l4 ">
            <h3 id="footer1strow">POPULAR TAGS</h3>
            <p>
             
           
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Dinner
              </span>{" "}
             
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #France
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Drinks
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Ideas
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Flavors
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Cuisine
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Chicken
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Dressing
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Fried
              </span>{" "}
              <span className="w3-tag w3-dark-grey w3-small w3-margin-bottom">
                #Fish
              </span>{" "}
             
            </p>
          </div>
        </footer>
      </div>
    );

};

export default FooterTop;
