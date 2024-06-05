package arraylist;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProfesoresEstudiantes {
    private ArrayList<String> listaProfesores;
    private ArrayList<ArrayList<String>> listaGeneralEstudiantes;

    public ProfesoresEstudiantes() {
        listaProfesores = new ArrayList<>();
        listaGeneralEstudiantes = new ArrayList<>();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarProfesores();
                    break;
                case 2:
                    registrarEstudiantes();
                    break;
                case 3:
                    consultarListaProfesoresyEstudiantes();
                    break;
                case 4:
                    consultarProfesor();
                    break;
                case 5:
                    consultarCantidadEstudiantesPorProfesor();
                    break;
                case 6:
                    consultarDirectorGrupo();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida, por favor ingrese nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    private int mostrarMenu() {
        String menu = "===== Menú =====\n"
                + "1. Registrar profesores\n"
                + "2. Registrar estudiantes asociados al profesor\n"
                + "3. Consultar lista total de profesores y sus estudiantes asociados\n"
                + "4. Consultar un profesor e imprimir la lista de estudiantes asociados\n"
                + "5. Consultar un profesor e indicar la cantidad de estudiantes asociados\n"
                + "6. Consultar un estudiante e indicar cuál es su director de grupo\n"
                + "0. Salir\n"
                + "Ingrese su opción: ";
        String opcionStr = JOptionPane.showInputDialog(menu);
        return validarEntradaNumerica(opcionStr) ? Integer.parseInt(opcionStr) : -1;
    }

    private boolean validarEntradaNumerica(String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida, por favor ingrese un número.");
            return false;
        }
    }

    private void registrarProfesores() {
        String cantProfesoresStr = JOptionPane.showInputDialog("Ingrese la cantidad de profesores a registrar:");
        if (!validarEntradaNumerica(cantProfesoresStr)) {
            return;
        }

        int cantProfesores = Integer.parseInt(cantProfesoresStr);
        for (int i = 0; i < cantProfesores; i++) {
            String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor " + (i + 1) + ":");
            if (listaProfesores.contains(nombreProfesor)) {
                JOptionPane.showMessageDialog(null, "El profesor ya está registrado.");
                i--; // Para que se vuelva a pedir el nombre del profesor
            } else {
                listaProfesores.add(nombreProfesor);
                listaGeneralEstudiantes.add(new ArrayList<>());
            }
        }

        JOptionPane.showMessageDialog(null, "Profesores registrados exitosamente.");
    }

    private void registrarEstudiantes() {
        if (listaProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe registrar al menos un profesor antes de registrar estudiantes.");
            return;
        }

        String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor:");

        if (!listaProfesores.contains(nombreProfesor)) {
            JOptionPane.showMessageDialog(null, "El profesor no está registrado.");
            return;
        }

        int indiceProfesor = listaProfesores.indexOf(nombreProfesor);

        String cantEstudiantesStr = JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes para el profesor " + nombreProfesor + ":");
        if (!validarEntradaNumerica(cantEstudiantesStr)) {
            return;
        }

        int cantEstudiantes = Integer.parseInt(cantEstudiantesStr);

        ArrayList<String> estudiantes = listaGeneralEstudiantes.get(indiceProfesor);
        for (int i = 0; i < cantEstudiantes; i++) {
            String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1) + ":");

            if (estudiantes.contains(nombreEstudiante)) {
                JOptionPane.showMessageDialog(null, "El estudiante ya está registrado.");
                i--; // Para que se vuelva a pedir el nombre del estudiante
            } else {
                estudiantes.add(nombreEstudiante);
            }
        }

        JOptionPane.showMessageDialog(null, "Estudiantes registrados exitosamente.");
    }

    private void consultarListaProfesoresyEstudiantes() {
        if (listaProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }

        String resultado = "===== Lista de Profesores y Estudiantes =====\n";
        for (int i = 0; i < listaProfesores.size(); i++) {
            resultado += "Profesor: " + listaProfesores.get(i) + "\n";
            resultado += "Estudiantes:\n";
            ArrayList<String> estudiantes = listaGeneralEstudiantes.get(i);
            if (estudiantes.isEmpty()) {
                resultado += "- No hay estudiantes registrados\n";
            } else {
                for (String estudiante : estudiantes) {
                    resultado += "- " + estudiante + "\n";
                }
            }
            resultado += "\n";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void consultarProfesor() {
        if (listaProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }

        String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor a consultar:");

        int indiceProfesor = listaProfesores.indexOf(nombreProfesor);
        if (indiceProfesor == -1) {
            JOptionPane.showMessageDialog(null, "El profesor no está registrado.");
        } else {
            String resultado = "Estudiantes asociados al profesor " + nombreProfesor + ":\n";
            ArrayList<String> estudiantes = listaGeneralEstudiantes.get(indiceProfesor);
            if (estudiantes.isEmpty()) {
                resultado += "- No hay estudiantes registrados\n";
            } else {
                for (String estudiante : estudiantes) {
                    resultado += "- " + estudiante + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private void consultarCantidadEstudiantesPorProfesor() {
        if (listaProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }

        String nombreProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor a consultar:");

        int indiceProfesor = listaProfesores.indexOf(nombreProfesor);
        if (indiceProfesor == -1) {
            JOptionPane.showMessageDialog(null, "El profesor no está registrado.");
        } else {
            ArrayList<String> estudiantes = listaGeneralEstudiantes.get(indiceProfesor);
            JOptionPane.showMessageDialog(null, "Cantidad de estudiantes asociados al profesor " + nombreProfesor + ": " + estudiantes.size());
        }
    }

    private void consultarDirectorGrupo() {
        if (listaProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados.");
            return;
        }

        String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar:");

        String directorGrupo = null;
        for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
            ArrayList<String> estudiantes = listaGeneralEstudiantes.get(i);
            if (estudiantes.contains(nombreEstudiante)) {
                directorGrupo = listaProfesores.get(i);
                break;
            }
        }

        if (directorGrupo == null) {
            JOptionPane.showMessageDialog(null, "El estudiante no está asociado a ningún profesor.");
        } else {
            JOptionPane.showMessageDialog(null, "El director de grupo del estudiante " + nombreEstudiante + " es: " + directorGrupo);
        }
    }

    public static void main(String[] args) {
        ProfesoresEstudiantes programa = new ProfesoresEstudiantes();
        programa.iniciar();
    }
}
