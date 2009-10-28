#

#OS specific support
OS="";
case "`uname`" in
  CYGWIN*) OS="cygwin";;
  Linux*)  OS="linux";;
esac

if [[ $OS == "cygwin" ]] ;then

fi
if [[ $OS == "linux" ]] ;then
echo "linux"
fi


echo "end";