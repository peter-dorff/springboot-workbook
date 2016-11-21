# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure(2) do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://atlas.hashicorp.com/search.
  config.vm.box = "ubuntu/trusty64"

  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  config.vm.synced_folder "./projects", "/home/vagrant/projects", create: true

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Define a Vagrant Push strategy for pushing to Atlas. Other push strategies
  # such as FTP and Heroku are also available. See the documentation at
  # https://docs.vagrantup.com/v2/push/atlas.html for more information.
  # config.push.define "atlas" do |push|
  #   push.app = "YOUR_ATLAS_USERNAME/YOUR_APPLICATION_NAME"
  # end

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  config.vm.provision "shell", privileged: false, inline: <<-SHELL
    
    # install tools - zip,unzip
    echo "Install unzip ..."
    sudo apt-get install unzip  > /dev/null 2>&1  

    # install git
    echo "Install git ..."
    sudo apt-get update  > /dev/null 2>&1
    sudo apt-get install -y git > /dev/null 2>&1
  
    # quietly add a user with password
    #sudo adduser --quiet --disabled-password --shell /bin/bash --home /home/git --gecos "User" git
    #sudo echo "git:git" | chpasswd
  
    # install jdk 8
    echo "Download jdk..."
    sudo wget --quiet --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u111-b14/jdk-8u111-linux-x64.tar.gz"
  
    echo "Install jdk..."
    sudo tar xzf jdk-8u111-linux-x64.tar.gz
    sudo mv jdk1.8.0_111 /opt
    sudo rm jdk-8u111-linux-x64.tar.gz
  
    echo "export JAVA_HOME=/opt/jdk1.8.0_111" >> javajdk.sh
    echo "export PATH=/opt/jdk1.8.0_111/bin:$PATH" >> javajdk.sh
    sudo chmod +x javajdk.sh
    sudo mv javajdk.sh /etc/profile.d/ 
    source /etc/profile.d/javajdk.sh
  
    # instsall sdkman
    echo "Install sdkman..."
    curl -s http://get.sdkman.io | bash > /dev/null 2>&1
    source "/home/vagrant/.sdkman/bin/sdkman-init.sh" 
    sed -i 's/sdkman_auto_answer=false/sdkman_auto_answer=true/g' ~/.sdkman/etc/config
 
    echo "Install groovy with sdkman..."
    sdk install groovy > /dev/null 2>&1
    echo "Install gradle with sdkman..."
    sdk install gradle > /dev/null 2>&1
    echo "Install maven with sdkman..."
    sdk install maven > /dev/null 2>&1
    echo "Install ant with sdkman..."
    sdk install ant > /dev/null 2>&1
    echo "Install springboot with sdkman..."
    sdk install springboot > /dev/null 2>&1
        
    # jenv, npm, nodejs, bower, grunt 
   SHELL
 
 end
