import React from "react";

const Search = () => {
  return (
    <section className="w12-row">
      <div className="w3-col s12 m12 l2">
        <input
          type="text"
          className="searchinput"
          placeholder="Search Offers, Deals, Brands..."
        />
      </div>
      <div className="select" style={{ textAlign: "right" }}>
        <select>
          <option>Latest</option>
          <option>Price (High to Low)</option>
          <option>Price (Low to High)</option>
          <option>Rating</option>
        </select>
      </div>
    </section>
  );
};

export default Search;
