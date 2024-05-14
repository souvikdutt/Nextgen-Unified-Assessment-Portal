import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import MenteesTable from './MenteesTable';
import Table from './Table';

export default function optionsForHR(props) {

    const styles = {
        display: 'block',
        padding: 30,
        position: 'absolute',
        right: 0
    }

return (
	<div style={styles} className='col-9'>
	
	<Tabs defaultActiveKey="first">
		<Tab eventKey="first" title="Initiate new UA">
		    
		</Tab>
        <Tab eventKey="second" title="Add New Mentor">
		    
		</Tab>
        <Tab eventKey="third" title="Current Mentors">
            <Table/>
		</Tab>
		<Tab eventKey="fourth" title="Current Mentees">
            <MenteesTable/>
		</Tab>
	</Tabs>
	</div>
);
}
