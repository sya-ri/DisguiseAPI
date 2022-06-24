package net.pinger.disguise;

import net.pinger.disguise.packet.PacketContext;
import net.pinger.disguise.packet.PacketProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisguiseAPI {

    private final Logger logger = LoggerFactory.getLogger("DisguiseAPI");
    private final PacketContext packetContext;

    private static DisguiseAPI disguise;

    // Don't let anyone initialize this
    private DisguiseAPI() {
        this.packetContext = new PacketContext();
    }

    /**
     * This method is used to assign a value to the {@link PacketProvider} field
     * which manages sent packets for disguised
     */

    public void applyProvider() {
        this.packetContext.applyProvider();
    }

    /**
     * This method registers the given provider, which will be instantiated
     * once the {@link #applyProvider()} is called if the versions match.
     * <p>
     * If the replace boolean is true, this version will replace any other class
     * that matches the provided version of this one. By default, the value is true.
     *
     * @param providerClass the class of the provider
     * @param replace whether we should replace any other classes with this noe
     */

    public void registerProvider(Class<? extends PacketProvider<?>> providerClass, boolean replace) {
        this.packetContext.registerProvider(providerClass, replace);
    }

    /**
     * This method registers the given provider.
     *
     * @param providerClass the given provider
     */


    public void registerProvider(Class<? extends PacketProvider<?>> providerClass) {
        this.packetContext.registerProvider(providerClass);
    }

    /**
     * This method returns the singleton instance of the api.
     *
     * @return the singleton instance
     */

    public static DisguiseAPI getInstance() {
        return disguise != null ?
                disguise : new DisguiseAPI();
    }

    /**
     * This method returns the current provider.
     *
     * @return the provider
     */

    public PacketProvider<?> getProvider() {
        return packetContext.getProvider();
    }

    /**
     * This method returns the standard logger
     * of the api.
     *
     * @return the logger
     */

    public static Logger getLogger() {
        return getInstance().logger;
    }
}
