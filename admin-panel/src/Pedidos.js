import {
    List,
    Datagrid,
    TextField,
    ReferenceField,
    Edit,
    SimpleForm,
    TextInput,
    NumberInput,
    ReferenceInput,
    SelectInput,
    Create,
    EditButton,
    DeleteButton,
} from 'react-admin';

// Listar pedidos
export const PedidoList = () => (
    <List>
        <Datagrid>
            <TextField source="id" label="ID Pedido" />
            <TextField source="cliente.nombre" label="Nombre Cliente" />
            <TextField source="descripcion" label="Descripción" />
            <TextField source="total" label="Total" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

/*
// Listar pedidos
export const PedidoList = () => (
    <List>
        <Datagrid rowClick="edit">
            <TextField source="id" label="ID" />
            <ReferenceField source="id_cliente" reference="clientes" label="Cliente">
                <TextField source="nombre" />
            </ReferenceField>
            <TextField source="descripcion" label="Descripción" />
            <TextField source="total" label="Total" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

*/

// Crear pedido
export const PedidoCreate = () => (
    <Create>
        <SimpleForm>
            <ReferenceInput source="cliente.id" reference="clientes" label="Cliente">
                <SelectInput optionText="nombre" />
            </ReferenceInput>
            <TextInput source="descripcion" label="Descripción" />
            <NumberInput source="total" label="Total" />
        </SimpleForm>
    </Create>
);

// Editar pedido
export const PedidoEdit = () => (
    <Edit>
        <SimpleForm>
            <ReferenceInput source="cliente.id" reference="clientes" label="Cliente">
                <SelectInput optionText="nombre" />
            </ReferenceInput>
            <TextInput source="descripcion" label="Descripción" />
            <NumberInput source="total" label="Total" />
        </SimpleForm>
    </Edit>
);

/*
// Crear pedido
export const PedidoCreate = () => (
    <Create>
        <SimpleForm>
            <ReferenceInput source="id_cliente" reference="clientes" label="Cliente">
                <SelectInput optionText="nombre" />
            </ReferenceInput>
            <TextInput source="descripcion" label="Descripción" />
            <NumberInput source="total" label="Total" />
        </SimpleForm>
    </Create>
);

// Editar pedido
export const PedidoEdit = () => (
    <Edit>
        <SimpleForm>
            <ReferenceInput source="id_cliente" reference="clientes" label="Cliente">
                <SelectInput optionText="nombre" />
            </ReferenceInput>
            <TextInput source="descripcion" label="Descripción" />
            <NumberInput source="total" label="Total" />
        </SimpleForm>
    </Edit>
);
*/
