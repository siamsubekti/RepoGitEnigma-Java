import React, {Component} from 'react';

class SearchBar extends React.Component {
    render() {
        return (
            <div class="search-container">  
                <input type="text" className="search" placeholder="search"/>{this.props.searchName}
            </div>        
        
            )
        }
    }

    export default SearchBar;