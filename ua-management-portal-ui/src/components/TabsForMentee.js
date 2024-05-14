import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import RequestForm from './RequestForm';
import Table from './Table';
import Roadmap from './Roadmap';

export default function optionsForMentee(props) {

    const styles = {
        display: 'block',
        padding: 30,
        position: 'absolute',
        right: 0
    }

return (
	<div style={styles} className='col-9'>
	
	<Tabs defaultActiveKey="first">
		<Tab eventKey="first" title="Request">
		    <RequestForm data={props}/>
		</Tab>
		<Tab eventKey="second" title="Mentor Tab">
            <Table/>
		</Tab>
		<Tab eventKey="third" title="Roadmap">
            <Roadmap/>
		</Tab>
	</Tabs>
	</div>
);
}
