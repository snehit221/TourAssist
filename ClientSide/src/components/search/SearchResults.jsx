import React from "react";
import "./SearchResults.css";
import ResultCard from "./ResultCard";

const SearchResults = ({ results }) => {
  return (
    <div className="search-results">
      {results.length > 0 &&
        results.map((packageItem, index) => (
          <ResultCard data={packageItem} className="result-card" />
        ))}
    </div>
  );
};

export default SearchResults;
