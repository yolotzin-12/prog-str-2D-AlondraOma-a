package com.example.demolistview.Service;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();//Recupera las lineas del archivo
        List<String> result = new ArrayList<>();//El listado de resultado con el formato deseado
        for(String line : lines){
            if(line==null || line.isBlank()) continue; //Ignorar las lineas nulas

            String[] parts = line.split("," , -1);
            String name = parts[0].trim();//Obtiene el nombre del arreglo
            String correo = parts[1].trim();//Obtiene el correo del arreglo

            String edad = (parts.length > 2) ? parts[2].trim() : " N/A";
            result.add(name+"--"+correo+"--"+edad+" años");//Se agrega a la lista de resultado con el formato deseado
        }
        return result;
    }

    public void addPerson(String name, String email, int age) throws IOException {
        validatePerson(name, email);
        validateage(age);

        String nameNoComa= name.replace(",", "");
        String emailNoComa= email.replace(",", "");
        repo.appendNewLine(nameNoComa+","+emailNoComa+","+age);
    }

    private void validatePerson(String name, String email) {
        if (name==null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em=(email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || ! em.contains(".")){
            throw new IllegalArgumentException("El correo es invalido");
        }
    }
    public void validateage(int Age) {
        if (Age < 0 || Age > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120 años");
        }
        if (Age < 18) {
            throw new IllegalArgumentException("Debes ser mayor de edad para registrarte");
        }
    }

}