import React, {Component} from 'react';
import '../App/App.css';

class Header extends React.Component {

    constructor(props){
        super(props);
    }

    render() {
        return (
            <div className="column">
                <div className="column1">
                    <header>
                        <h1 className="headername">{this.props.headerName}</h1>
                    </header>
                </div>
            </div>
        )
    }
}

export default Header;