package interfaces;

public interface IConsultas {
    /*
        1. Tomando en cuenta las películas y las evaluaciones que los usuarios realizaron
        sobre las mismas, indicar el Top 5 de las películas en idioma original Inglés, Francés,
        Italiano, Español y Portugues con más evaluaciones por parte de los usuarios.
        Datos esperados del resultado:

            - Id de la película.
            - Título de la película.
            - Total de evaluaciones.
            - Idioma Original
     */
    void Top5PeliculasPorIdiomaMasCalificadas();



    /*
        2. Con las mismas consideraciones que en el caso anterior, indicar el Top 10 de las
        películas que mejor calificación media tienen por parte de los usuarios.
        Datos esperados del resultado:

            - Id de la película.
            - Título de la película.
            - Calificación media.
     */
    void Top10PeliculasConMejorCalificacionMedia();



    /*
        3. Una película puede pertenecer a una saga (o colección de películas). Agrupando las
        películas por saga, indicar el Top 5 de las colecciones que más ingresos generaron.
        Si una película no es parte de una saga, ella misma se debe considerar como una
        saga
        Datos esperados del resultado:

            - Id de la colección (o película).
            - Título de la colección (o película).
            - Cantidad de películas.
            - Conjunto de Ids de películas que la componen.
            - Ingresos generados.
     */
    void Top5ColeccionesConMasIngresos();



    /*
        4. Una película tiene un director. En general, los directores tienen cierto renombre y sus
        películas suelen tener una calidad similar. Considerando todas las películas de cada
        director, indicar el Top 10 de los directores que mejor calificación tienen. Únicamente
        se deben considerar directores con más de 1 película y más de 100 evaluaciones.
        Se deberá utilizar la mediana como métrica de comparación.
        Datos esperados del resultado:

            - Nombre del director.
            - Cantidad de películas.
            - Mediana de su calificación.
     */
    void Top10DirectoresMejorCalificados();



    /*
        5. Es sabido que hay épocas en las que ciertas películas son más vistas que otras.
        Para promocionar mejor estas películas, se desea saber qué actor es más común en
        ellas. Puntualmente, se desea saber cual es el actor con más calificaciones recibidas
        en cada mes del año.
        Datos esperados del resultado:

            - Mes del año.
            - Nombre del actor.
            - Cantidad de películas (que fueron vistas en ese mes).
            - Cantidad de calificaciones.
     */
    void ActorMasCalificadoPorMes();



    /*
        6. Finalmente, la empresa quiere premiar a los usuarios que más participen evaluando
        películas, para ello necesita saber que usuarios evalúan más películas por cada
        género. Pero al haber tantos géneros solo necesitan saber los top 10 géneros más
        vistos.
        Datos esperados del resultado:

            - Id del usuario
            - Género
            - Cantidad de evaluaciones de ese usuario sobre ese género.
     */
    void UsuariosConMasCalificacionesTop10Generos();
}
