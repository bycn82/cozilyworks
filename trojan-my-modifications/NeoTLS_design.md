# Goal
This piece of code will help people hide their traffic from the firewall (hereinafter referred to as "firewall") between the end user and the proxy server.

There is an old Chinese saying - 大隐隐于市. I may not understand its original meaning properly, but at least, literary, it means, the best way to hide your traffic is to hide among the most common traffic which is HTTPS. 

It is inspired by project "Trojan", "XTLS" and the "Project X".

# Objective & Design
1. Differentiate the Client Hello
According to the TLS1.3 spec, the random of the packet is really just a random value. Our client will AES GCM the random with a pre-shared key. Hence, it is AEAD! on the server, if the random can be decrypted on the proxy server, [if needed, the plaintext of the random can be in format, e,g, prefix with something].. So, the packet from our client can be detected. Hence on the proxy server:
    1. If the Client Hello is TLS 1.2, then forward to a fallback server
    2. if the Client Hello is not from our Client, e.g. from a browser, then forward ...
    3. If the packet is from our Client, then work as a proxy server
So, we dont need to setup a web server by ourself, instead, we can use existing famous website. e.g Microsoft.com

2. Forward Secrecy
1st piority of this project is to hide traffic from the firewall, but since we are using TLS1.3, and we can use the Client Hello & Server Hello to exchange the key like the TLS1.3 did. Hence, we are DHE. To be precise, it is ECDHE. no different from the TLS1.3

3. Proven the "Replay" attack.
First, the packets are AESGCM encrypted, hence, there is no way that the firewall can generate the packet. but the firewall can still capture the packets and "replay".
    1. if the firewall replays the Client Hello, then the proxy server will just reply as normal. (cannot tell whether the hello is from the firewall or the client). but it is encrypted with a pre-shared key, Hence the firewall should not be able to get the information.
    2. if the firewall replays the Application Data packet, then , we can have a counter on the client and the server. it is TLS1.3, which means it is TCP, no packet lost, hence, the counter is trustable. we can have a counter in the packet, hence the replayed packets can be deteted, or we can just simply encrypt the packet with the counter (technically, passwd = passwd + counter).
# Implimentation
    0. Prepare the PWD + IV
    1. Client Hello
        RANDOM = AES GCM (randon N1 + PWD + IV)
        -------------------------------------------------> the client genreates N1
        key shared = pub key of the client
    2. Check Hello on Server
        verify the RANDOM
            invalid?  forward to fallback URL
            valid?  get the N1
        -------------------------------------------------> the server got N1
    3. Server Hello
        RANDOM = AES GCM (randon N2 +  + N1 + PWD + IV)
        -------------------------------------------------> the server genreates N2
        key shared = pub key of the server
        --------------------------------------------------> the server got both pub keys, then DH() get S
    4. Check Hello on the Client
        verify the RANDOM
            valid?  get the N2 (the client has N1)
        -------------------------------------------------> the client got N2
        --------------------------------------------------> the client got both pub keys, then DH() get S
    
    Hence, both the server and the client got a S which is derived from the pub keys.
        and the N1, N2
    
    5. Application Data
        AES GCM or Chacha20 + Poly 1905  encrypt with (S1 + N1 + N2 + Counter + PWD + IV)
 
# Notes
    1. use source of crypto/tls
    2. speed up the encryption, like XTLS, detect the connection, if it is TLS, then no need to encrypt again.
        use socks5 for the inbond is easier to detect the connection type.
    3, once detect the replay attach, inform the iptable/ipfw to block the client. the firewall is the right way to do the blocking.
    4. bandwidth control should be done by the firewall as well
    5. the user authentication????
    6. ICMP or HTTPS to receive the PWD & IV,
    7.
    
    
    