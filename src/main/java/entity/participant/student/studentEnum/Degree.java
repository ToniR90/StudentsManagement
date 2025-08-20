package entity.participant.student.studentEnum;

import exception.personalException.InvalidDegreeException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Degree {
    EEIA("EEIA" , "Enginyeria Electrònica Industrial i Automàtica"),
    EIGSI("EIGSI" , "Enginyeria Informàtica de Gestió i Sistemes d'Informació"),
    EM("EM" , "Enginyeria Mecànica"),
    MA("MA" , "Mitjans Audiovisuals"),
    DPV("DPV" , "Disseny i Producció de Videojocs"),
    EOI("EOI" , "Enginyeria d'organització Industrial"),
    AEGI("AEGI" , "Administració d'Empreses i Gestió de la Innovació"),
    TGL("TGL" , "Turisme i Gestió del Lleure"),
    MCD("MCD" , "Màrqueting i Comunitats Digitals"),
    LNM("LNM" , "Logística i Negocis Marítims"),
    I("I" , "Infermeria"),
    CAFE("CAFE" , "Ciències de l'Activitat Física i de l'Esport"),
    F("F" , "Fisioteràpia"),
    NHD("NHD" , "Nutrició Humana i Dietètica"),
    IGSI_DPV("IGSI_DPV" , "Informàtica de Gestió i Sistemes d'Informació + Dissenys i Producció de Videojocs"),
    TGL_AEGI("TGL_AEGI" , "Turisme i Gestió del Lleure + Administració d'Empreses i Gestió de la Innovació"),
    F_CAFE("F_CAFE" , "Fisioteràpia + Ciències de l'Activitat Física i de l'Esport"),
    EEIA_EM("EEIA_EM" , "Enginyeria Electrònica Industrial i Automàtica + Enginyeria Mecànica"),
    DPV_MA("DPV_MA" , "Disseny i Producció de Videojocs + Mitjans Audiovisuals"),
    EE_EIGSI("EE_EIGSI" , "Enginyeria Electrònica + Enginyeria Informàtica de Gestió i Sistemes d'informació");

    private final String code;
    private final String label;

    public static Degree fromCode(String code) {
        if(code == null || code.trim().isEmpty()) {
            throw new InvalidDegreeException("null or empty");
        }
        return Arrays.stream(values())
                .filter(d -> d.code.equalsIgnoreCase(code.trim()))
                .findFirst()
                .orElseThrow(() -> new InvalidDegreeException(code));
    }
}
