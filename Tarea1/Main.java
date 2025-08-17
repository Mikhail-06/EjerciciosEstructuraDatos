package Tarea1;

import java.util.Scanner;

class Node {
    Object dato;
    Node sig;
    Node ant;
}

class LinkedList {
    Node inicio;

    void add(Object x) {
        Node n = new Node();
        n.dato = x;
        if (inicio == null) {
            inicio = n;
        } else {
            Node aux = inicio;
            while (aux.sig != null) {
                aux = aux.sig;
            }
            aux.sig = n;
            n.ant = aux;
        }
    }

    void print() {
        Node aux = inicio;
        if (aux == null) {
            System.out.println("(lista vacia)");
            return;
        }
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.sig;
        }
    }

    Object buscar(String nombre) {
        Node aux = inicio;
        while (aux != null) {
            if (aux.dato instanceof Contacto) {
                Contacto c = (Contacto) aux.dato;
                if (c.nombre.equals(nombre)) {
                    return c;
                }
            }
            aux = aux.sig;
        }
        return null;
    }

    void eliminar(String nombre) {
        if (inicio == null) return;
        if (inicio.dato instanceof Contacto) {
            Contacto c = (Contacto) inicio.dato;
            if (c.nombre.equals(nombre)) {
                inicio = inicio.sig;
                return;
            }
        }
        Node aux = inicio;
        while (aux.sig != null) {
            if (aux.sig.dato instanceof Contacto) {
                Contacto c2 = (Contacto) aux.sig.dato;
                if (c2.nombre.equals(nombre)) {
                    aux.sig = aux.sig.sig;
                    return;
                }
            }
            aux = aux.sig;
        }
    }
}

class Contacto {
    String nombre;
    String direccion;
    String telefono;

    Contacto(String n, String d, String t) {
        nombre = n;
        direccion = d;
        telefono = t;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Dir: " + direccion + ", Tel: " + telefono;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList contactos = new LinkedList();

        int op = 0;
        while (op != 5) {
            System.out.println("=== GESTION DE CONTACTOS ===");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("Nombre:");
                String n = sc.nextLine();
                System.out.println("Direccion:");
                String d = sc.nextLine();
                System.out.println("Telefono:");
                String t = sc.nextLine();
                Contacto c = new Contacto(n, d, t);
                contactos.add(c);
            }
            if (op == 2) {
                contactos.print();
            }
            if (op == 3) {
                System.out.println("Nombre a buscar:");
                String nb = sc.nextLine();
                Object res = contactos.buscar(nb);
                if (res != null) {
                    System.out.println("Encontrado: " + res);
                } else {
                    System.out.println("No existe");
                }
            }
            if (op == 4) {
                System.out.println("Nombre a eliminar:");
                String ne = sc.nextLine();
                contactos.eliminar(ne);
            }
        }
    }
}

