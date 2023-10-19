package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.servicios.interfaces.ImagenesServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImagenesServicioImpl implements ImagenesServicio {

    private final Cloudinary cloudinary;

    public ImagenesServicioImpl(){

        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "paula");
        config.put("api_key", "654309872100");
        config.put("api_secret", "!hVy7GxDA4koMruk");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(MultipartFile imagen) throws Exception {

        File file = convertir(imagen);
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                "clinica"));
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {

        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }

    private File convertir(MultipartFile imagen) throws IOException {

        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}
