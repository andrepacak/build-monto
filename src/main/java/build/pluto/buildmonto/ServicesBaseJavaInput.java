package build.pluto.buildmonto;

import build.pluto.builder.BuildManagers;
import build.pluto.builder.BuildRequest;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ServicesBaseJavaInput implements Serializable {
    public final File src;
    public final File target;
    public final File jarLocation;
    public List<BuildRequest<?, ?, ?, ?>> requiredUnits;

    public ServicesBaseJavaInput(
            File src,
            File target,
            File jarLocation,
            List<BuildRequest<?, ?, ?, ?>> requiredUnits) {
        this.src = src;
        this.target = target;
        this.jarLocation = jarLocation;
        this.requiredUnits = requiredUnits;
    }
    public static void main(String[] args) throws IOException {
        ServicesBaseJavaInput input = new ServicesBaseJavaInput(
                new File("services-base-java"),
                new File("targetsb"),
                new File("sbj.jar"),
                null);
        BuildManagers.build(
                new BuildRequest<>(ServicesBaseJavaBuilder.factory, input));
	}
}
