package br.com.fiap.util;

import br.com.fiap.modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Lê o arquivo hibernate.cfg.xml e cria a configuração
            Configuration configuration = new Configuration().configure();
            
            // Adiciona as classe mapeadas
            configuration.addAnnotatedClass(Pessoa.class);
            configuration.addAnnotatedClass(PessoaFisica.class);
            configuration.addAnnotatedClass(PessoaJuridica.class);

            // Cria o ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            // Cria a SessionFactory
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Exception ex) {
            System.err.println("Falha na criação da SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retorna a SessionFactory (singleton)
     */
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    /**
     * Fecha a SessionFactory quando a aplicação encerrar
     */
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}

