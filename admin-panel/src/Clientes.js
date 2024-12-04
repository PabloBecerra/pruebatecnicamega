import {
    List,
    Datagrid,
    TextField,
    Edit,
    SimpleForm,
    TextInput,
    Create,
    EditButton,
    DeleteButton,
} from 'react-admin';

// Listar clientes
export const ClienteList = () => (
    <List>
        <Datagrid rowClick="edit">
            <TextField source="id" label="ID" />
            <TextField source="nombre" label="Nombre" />
            <TextField source="telefono" label="Teléfono" />
            <TextField source="email" label="Email" />
            <TextField source="direccion" label="Dirección" />
            <EditButton />
            <DeleteButton />
        </Datagrid>
    </List>
);

// Crear cliente
export const ClienteCreate = () => (
    <Create>
        <SimpleForm>
            <TextInput source="nombre" label="Nombre" />
            <TextInput source="telefono" label="Teléfono" />
            <TextInput source="email" label="Email" />
            <TextInput source="direccion" label="Dirección" />
        </SimpleForm>
    </Create>
);

// Editar cliente
export const ClienteEdit = () => (
    <Edit>
        <SimpleForm>
            <TextInput source="nombre" label="Nombre" />
            <TextInput source="telefono" label="Teléfono" />
            <TextInput source="email" label="Email" />
            <TextInput source="direccion" label="Dirección" />
        </SimpleForm>
    </Edit>
);
