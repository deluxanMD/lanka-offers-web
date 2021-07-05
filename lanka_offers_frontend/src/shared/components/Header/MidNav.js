import React, { useState } from "react";
import './MidNav.css';
import lanka from "../../../assets/images/logo/lanka.jpeg"; // with import
import Modal from "../UIElements/Modal";
import { Tab, TabPanel, Tabs, TabList } from "react-web-tabs";
import "react-web-tabs/dist/react-web-tabs.css";

const MidNav = (props) => {
  const lastnavOpen = () => {
    var element = document.getElementById("lastnav");
    element.classList.toggle("w3-hide-small");
  };

  const MidnavOpen = () => {
    var element = document.getElementById("hidenav");
    element.classList.toggle("w3-hide-small");
  };

  const [Location, setLocation] = useState(false);

  const openLocationHandler = () => setLocation(true);

  const closeLocationHandler = () => setLocation(false);

  return (
    <React.Fragment>
      <Modal
        show={Location}
        onCancel={closeLocationHandler}
        header="Location"
        contentClass="place-item__modal-content"
        footerClass="place-item__modal-actions"
        footer={
          <button
          className="buttonh"
            onClick={closeLocationHandler}
          >
            Close
          </button>
        }
      >
        <div className="w3-container w3-margin-top">
          <div className="w3-row w3-center">
            <div className="w3-col s12 m6 l8 w3-margin-bottom">
              <input
                type="text"
                className="searchinput"
                placeholder="Search places"
              ></input>
            </div>

            <div className=" w3-col s4 m6 l4 ">
              <button class="w3-button w3-pink w3-round w3-hover-brown">
                <i className="fa fa-map-marker" />
                &nbsp; Pick Me
              </button>
            </div>
          </div>
          <div className=" w3-margin ">
            <Tabs
              defaultTab="vertical-tab-one"
              vertical
              className="vertical-tabs"
            >
              <TabList>
                <Tab tabFor="vertical-tab-one">Collombo</Tab>
                <Tab tabFor="vertical-tab-two">Jaffna</Tab>
                <Tab tabFor="vertical-tab-three">Kandy</Tab>
              </TabList>

              <TabPanel tabId="vertical-tab-one">
              <ul class="w3-ul w3-hoverable">
              <li>Dehiwala</li>
              <li>Borella</li>
              <li>Petta</li>
            </ul>
              </TabPanel>

              <TabPanel tabId="vertical-tab-two">
              <ul class="w3-ul w3-hoverable">
              <li>Nallur</li>
              <li>Jaffna</li>
              <li>Chunnakam</li>
            </ul>
              </TabPanel>

              <TabPanel tabId="vertical-tab-three">
                <p>Kandy</p>
              </TabPanel>
            </Tabs>
           
          </div>
        </div>
      </Modal>
      <div className="w3-row midnav">
        <div className="w3-col s10 m10 l3">
          <a href="#home">
            <img src={lanka} style={{ width: "50px", maxHeight: "50px" }} />
          </a>
          <a href="#home" className="logo">
            Lanka Offers
          </a>
        </div>
        <div className="w3-col s2 m2">
          <a
            className="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
            onClick={MidnavOpen}
            title="Toggle "
          >
            <i
              className="fa fa-search"
              style={{ fontSize: "26px", color: "#de206a" }}
            ></i>
          </a>
        </div>
        <div id="hidenav" className="w3-hide-small">
          <div className="w3-col s12 m12 l6">
            <div className="search">
              <input
                type="text"
                className="searchinput"
                placeholder="Search Offers, Deals, Brands..."
              ></input>
            </div>
          </div>
          <div className="midnav-right w3-col s6 m6 l2 ">
            <a href="#contact" onClick={openLocationHandler}>
              <i
                className="fa fa-map-marker"
                style={{ fontSize: "22px", color: "#de206a" }}
              />
              &nbsp; All of Srilanka
            </a>
          </div>

          <div id="hidenav" className=" midnav-right w3-col s6 m6">
            <a
              className="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right"
              onClick={lastnavOpen}
              title="Toggle "
            >
              <i className="fa fa-bars"></i>
            </a>
          </div>
        </div>
      </div>
    </React.Fragment>
  );
};

export default MidNav;
