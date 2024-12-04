import React from "react";
import { Admin, Resource } from "react-admin";
import simpleRestProvider from "ra-data-simple-rest";
import { ClienteList, ClienteEdit, ClienteCreate } from "./Clientes";
import { PedidoList, PedidoEdit, PedidoCreate } from "./Pedidos";

const dataProvider = simpleRestProvider("http://49.13.235.240:8080/api");

const App = () => (
    <Admin dataProvider={dataProvider}>
        <Resource
            name="clientes"
            list={ClienteList}
            edit={ClienteEdit}
            create={ClienteCreate}
        />
        <Resource
            name="pedidos"
            list={PedidoList}
            edit={PedidoEdit}
            create={PedidoCreate}
        />
    </Admin>
);

export default App;








/*import React from "react";
import { Admin, Resource } from "react-admin";
import simpleRestProvider from "ra-data-simple-rest";
import { ClienteList } from "./Clientes";
import { PedidoList } from "./Pedidos";

const dataProvider = simpleRestProvider("http://localhost:8080/api");

const App = () => (
    <Admin dataProvider={dataProvider}>
        <Resource name="clientes" list={ClienteList} />
        <Resource name="pedidos" list={PedidoList} />
    </Admin>
);

export default App;

*/


/*import React from "react";
import { Admin, Resource, ListGuesser } from "react-admin";
import simpleRestProvider from "ra-data-simple-rest";

const dataProvider = simpleRestProvider("http://localhost:8080/api");

const App = () => (
    <Admin dataProvider={dataProvider}>
        <Resource name="clientes" list={ListGuesser} />
        <Resource name="pedidos" list={ListGuesser} />
    </Admin>
);

export default App;
*/





/*import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
*/
