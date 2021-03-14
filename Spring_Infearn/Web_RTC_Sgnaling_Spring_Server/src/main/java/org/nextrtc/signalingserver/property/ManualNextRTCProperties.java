package org.nextrtc.signalingserver.property;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class ManualNextRTCProperties implements NextRTCProperties {

    private int maxConnectionSetupTime = 30;

    private int pingPeriod = 3;

    private int schedulerPoolSize = 10;

    private boolean joinOnlyToExisting = false;

    private String defaultConversationType = "MESH";
}
