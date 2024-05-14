import React from 'react';
import 'bootstrap/dist/css/bootstrap.css';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import MenteesTable from './MenteesTable';

export default function optionsForMentor(props) {

    const styles = {
        display: 'block',
        padding: 30,
        position: 'absolute',
        right: 0
    }

return (
	<div style={styles} className='col-9'>
	<h3>Welcome Mentor!</h3>
	<Tabs defaultActiveKey="first">
		<Tab eventKey="first" title="Request">
		    
		</Tab>
		<Tab eventKey="second" title="Your Mentees">
            <MenteesTable/>
		</Tab>
	</Tabs>
	</div>
);
}
